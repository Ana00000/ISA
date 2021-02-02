<template>
    <div>
        <div class="panelDiv">
            <DermatologistMenu/>
        </div>
        <div class="panelDiv"/>
    </div>
</template>

<script>
import DermatologistMenu from '../components/DermatologistMenu.vue'
export default {
    name : 'DermatologistHomePage',
    components : {
        DermatologistMenu
    },
    data() {
        return{
            items: []
        }
    }
}
</script>

<style scoped>
.panelDiv {
    float: right;
}

.backgroundDiv {
  background: url('https://wallup.net/wp-content/uploads/2017/11/17/260979-pills-pharmacy.jpg');
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>