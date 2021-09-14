<template>
    <v-container style="padding: 0px" fluid fill-height dark>
        <v-layout>
            <SupplierMenu/>
            <div class="panelDiv" style="width:50%;">
                <div style="margin: 50px;"><h2 class="display-3">Personal Data</h2></div>
                <div style="background: none; border: none; margin-right: 100px;">
                    <v-container fluid class="container">
                        <v-row>
                        <v-col cols="5"/>
                        <v-col cols="3">
                            <v-text-field
                                label="Name"
                                v-model="name"
                                hint="Your name should contain at least 2 characters!"/>
                        </v-col>
                        </v-row>

                        <v-row>
                        <v-col cols="5"/>
                        <v-col cols="3">
                            <v-text-field
                            label="Last name"
                            v-model="lastName"
                            hint="Your last name should contain at least 2 characters!"/>
                        </v-col>
                        </v-row>

                        <v-row>
                        <v-col cols="5"/>
                        <v-col cols="3">
                            <v-text-field
                            label="Address"
                            v-model="address"
                            hint="Your address should contain at least 3 characters!"/>
                        </v-col>
                        </v-row>
                        
                        <v-row>
                        <v-col cols="5"/>
                        <v-col cols="3">
                            <v-text-field
                            label="Phone number"
                            v-model="phoneNumber"
                            hint="Your phone number should contain 9 or 10 numbers!"/>
                        </v-col>
                        </v-row>

                        <br/><br/>
                    </v-container>
                </div>
            </div>
            <div style="width:25%; margin-top: 10%; padding-right: 10%;">
                <div class="updatePng">
                    <img :src="updatePng" width="350px" height="350px"/>
                </div>

                <div class="updateButton">
                    <v-btn
                        v-on:click="updateProfile" 
                        color="#aba7ff"
                        elevation="24"
                        x-large
                        raised
                        rounded
                    >Update info</v-btn>
                    <v-btn
                        v-on:click="changePassword" 
                        color="#aba7ff"
                        elevation="24"
                        x-large
                        raised
                        rounded
                        style="margin-top:20px"
                    >Change password</v-btn>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import userImage from "../../assets/user_profile.jpg"
import updatePng from "../../assets/update_profile.png"
import SupplierMenu from "../../components/supplier/SupplierMenu.vue"
export default {
    name : 'profile',
    components : {
        SupplierMenu,
    },
    data: () => ({
        id: null,
        name: '',
        lastName: '',
        email: '',
        address: '',
        phoneNumber: '',
        active: true,
        type: '',
        password:'',
        userImage: userImage,
        updatePng: updatePng
    }),
    mounted() {
        this.init();
    },
    methods: {
        init() {
            this.setPatient();
        },
        changePassword(){
            window.location.href = 'http://localhost:8080/supplierHomePage/ChangePassword';
        },
        setPatient() {
            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
            this.id = this.$route.params.id;
            this.$http.get('http://localhost:8081/supplier/getSupplier', config).then(resp => {
                console.log(resp.data);
                this.setPatientInfo(resp.data);
            }).catch(err => console.log(err));
        },
        setPatientInfo(item) {
            this.id = item.id;
            this.name = item.name;
            this.lastName = item.lastName;
            this.email = item.email;
            this.password = item.password;
            this.address = item.address;
            this.phoneNumber = item.phoneNumber;
            this.active = item.active;
        },  
        updateProfile() {
            const config = {
                headers: { Authorization: `Bearer ${localStorage.getItem("token")}` }
            };
            this.validationOfInput();
            this.$http.post('http://localhost:8081/supplier/editSupplier', 
            {         
                id : this.id,
                name : this.name,
                lastName : this.lastName,
                email : this.email,
                address : this.address,
                phoneNumber : this.phoneNumber,
                active : this.active,
                hashString: null
            },config
            ).then(resp => {
                alert("User edited !");
                console.log(resp.data);
            }).catch(err => console.log(err));
        },
        validationOfInput() {
            this.validationOfName();
            this.validationOfLastName();
            this.validationOfEmail();
            this.validationOfAddress();
            this.validationOfPhoneNumber();
        },
        validationOfName() {
            if(this.name.length < 2)
            {
                alert("Your name should contain at least 2 characters!");
                return;
            }else if(this.name.length > 20)
            {
                alert("Your name shouldn't contain more than 20 characters!");
                return;
            }
        },
        validationOfLastName() {
            if(this.lastName.length < 2)
            {
                alert("Your last name should contain at least 2 characters!");
                return;
            }else if(this.lastName.length > 20)
            {
                alert("Your last name shouldn't contain more than 20 characters!");
                return;
            }
        },
        validationOfEmail() {
            if(this.email.length < 5)
            {
                alert("Your email should contain at least 5 characters!");
                return;
            }else if(this.email.length > 35)
            {
                alert("Your email shouldn't contain more than 35 characters!");
                return;
            }
        },
        validationOfAddress() {
            if(this.address.length < 3)
            {
                alert("Your address should contain at least 3 characters!");
                return;
            }else if(this.address.length > 50)
            {
                alert("Your address shouldn't contain more than 50 characters!");
                return;
            }
        },
        validationOfPhoneNumber() {
            this.validationOfPhoneNumberLength();
            this.validationOfPhoneNumberElements();
        }, 
        validationOfPhoneNumberLength() {
            if(this.phoneNumber.length < 6)
            {
                alert("Your phone number should contain at least 6 characters!");
                return;
            }else if(this.phoneNumber.length > 10)
            {
                alert("Your phone number shouldn't contain more than 10 characters!");
                return;
            }
        },
        validationOfPhoneNumberElements() {
            var keysAllowed = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '/', '-'];
            for(var element = 0; element < this.phoneNumber.length; element++)
            {
                if(!keysAllowed.includes(this.phoneNumber[element]))
                {
                    alert("Your phone number can contain only numbers and / - characters!");
                    return;
                }
            }
        }
    }
}
</script>

<style scoped>

.panelDiv {
    width: 100%;
    margin: 0auto;
    background: none;
    border: none;
}
</style>