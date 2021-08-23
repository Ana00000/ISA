<template>
  <div>
    <SystemAdminMenu/>
      <v-card width="400" class="mx-auto mt-5" color="white">
    <v-card-title class="justify-center">
      <h1 class="display-1 ">Add medicine</h1>
    </v-card-title>
    <v-card-text>
      <v-form class="mx-auto ml-5 mr-5">
        <v-text-field
            label="Medicine name"
            v-model="name"
            prepend-icon="mdi-needle" />
        <v-text-field
            label="code"
            v-model="code"
            prepend-icon="mdi-qrcode-edit"/>
        <v-text-field
          label="Daily intake"
          v-model="recommendedIntake"
          prepend-icon="mdi-address-circle"
          type="number"/>
        <v-text-field
          label="Points user get"
          v-model="points"
          prepend-icon="mdi-address-circle"
          type="number"/>
        <v-text-field
          label="Price"
          v-model="price"
          prepend-icon="mdi-address-circle"
          type="number"/>
        <v-select
            v-model="selectedMedicineType"
            :items="medicineType"
            item-text="type"
            item-value="type"
            label="Type of medicine"
            prepend-icon="mdi-address-circle"
        ></v-select>
        <v-select
            v-model="selectedMedicinyIngredient"
            :items="medicinyIngredient"
            item-text="name"
            item-value="name"
            label="Medicine ingredient"
            prepend-icon="mdi-address-circle"
            multiple
        ></v-select>
        <v-select
            v-model="selectedMedicines"
            :items="medicines"
            item-text="name"
            item-value="name"
            label="Alternative medicine"
            prepend-icon="mdi-address-circle"
            multiple
        ></v-select>
        <v-select
            v-model="selectedMedicineShape"
            :items="medicineShapes"
            item-text="name"
            item-value="name"
            label="Medicine shape"
            prepend-icon="mdi-address-circle"
        ></v-select>
        <v-select
            v-model="selectedMedicineManufacturers"
            :items="medicineManufacturers"
            item-text="name"
            item-value="name"
            label="Medicine manufacturers"
            prepend-icon="mdi-address-circle"
        ></v-select>
        <v-textarea
          v-model="contraindications"
          filled
          name="input-7-4"
          label="Contraindications:"
          prepend-icon="mdi-address-circle"
        ></v-textarea>
        <v-checkbox
      v-model="recipeNeed"
      :label="`Is recipe needed:`"
      prepend-icon="mdi-address-casdasasdrcle"
    ></v-checkbox>
      </v-form>
    </v-card-text>
    <v-card-actions class="justify-center mb-5">
      <v-btn color="info mb-5" v-on:click="add">
        Add medicine  
      </v-btn>
    </v-card-actions>
  </v-card> 
  </div>
</template>

<script>
import SystemAdminMenu from '../../components/systemAdmin/SystemAdminMenu.vue'
export default {
  components: { SystemAdminMenu },
  name: 'SystemAdminAddMedicine',
  data: ()=>({
    name:"",
    code:"",
    recipeNeed:false,
    medicineType:[],
    selectedMedicineType:null,
    medicinyIngredient:[],
    selectedMedicinyIngredient:null,
    contraindications:"",
    recommendedIntake:0,
    medicines:[],
    selectedMedicines:null,
    medicineShapes:[],
    selectedMedicineShape:null,
    medicineManufacturers:[],
    selectedMedicineManufacturers:null,
    points:0,
    price:0,
  }),  
  computed: {
    medicineToAdd() {
      return {'name':this.name,'recipeNeed':this.recipeNeed,'medicineManufacturer':this.selectedMedicineManufacturers,
      'medicineShape':this.selectedMedicineShape,'medicinesIngredients':this.selectedMedicinyIngredient,
      'alternativeMedicines':this.selectedMedicines,'code':this.code,'medicinType':this.selectedMedicineType,
      'contraindications':this.contraindications,'recommendedIntake':parseInt(this.recommendedIntake,10),
      'medicineShapeName':this.selectedMedicineShape,'points':this.points,'price':this.price}
    }
  },
  methods:{
      add(){
        var tokenString = '';
        tokenString = localStorage.getItem("token");
        const config = {
                headers: {Authorization: `Bearer ${tokenString}`}
        };
        console.log("medicine to add ",this.medicineToAdd);
        this.$http.post('http://localhost:8081/medicine/add',this.medicineToAdd,config)
        .then(resp => {
          console.log(resp.data);
          alert("Successfully added !")
          window.location.href = 'http://localhost:8080/systemAdminHomePage';
        })
        .catch(er => {
          console.log('Error while adding medicine');
          console.log(er.response.data);
        })
      },
  },
  beforeMount(){
    this.$http.get('http://localhost:8081/medicineType/allMedicineType')
    .then(resp => {
      this.medicineType = resp.data;
      console.log(resp.data);
    })
    .catch(er => {
      console.log('Error while loading medicine types');
      console.log(er.response.data);
    });

    this.$http.get('http://localhost:8081/medicineIngredients/all')
    .then(resp => {
      this.medicinyIngredient = resp.data;
      console.log(resp.data);
    })
    .catch(er => {
      console.log('Error while loading medicine ingredient');
      console.log(er.response.data);
    });

    this.$http.get('http://localhost:8081/medicine/all')
    .then(resp => {
      this.medicines = resp.data;
      console.log(resp.data);
    })
    .catch(er => {
      console.log('Error while loading medicine');
      console.log(er.response.data);
    });

    this.$http.get('http://localhost:8081/medicineShapes/allStefan')
    .then(resp => {
      this.medicineShapes = resp.data;
      console.log(resp.data);
    })
    .catch(er => {
      console.log('Error while loading medicine shapes');
      console.log(er.response.data);
    });

    this.$http.get('http://localhost:8081/medicineManufacturers/all')
    .then(resp => {
      this.medicineManufacturers = resp.data;
      console.log(resp.data);
    })
    .catch(er => {
      console.log('Error while loading medicine Manufacturers');
      console.log(er.response.data);
    });
  },
}
</script>

<style>

</style>