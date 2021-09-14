<template>
     <div class="backgroundDiv">
        <SupplierMenu/>
    </div>
</template>

<script>
import SupplierMenu from '../../components/supplier/SupplierMenu.vue'
export default {
  components: { SupplierMenu },
    name:'supplierHomePage'
}
</script>

<style>
.backgroundDiv {
  background: url('https://www.rwe.com/-/media/RWE/images/04-massgeschneiderte-loesungen/lieferantenportal/lieferantenmanagement/STA02-lieferantenauswahl.jpg?db=web&mw=479&w=498&hash=2D9FC8524A4607E512E125D8EC2CC4A6,%20/-/media/RWE/images/04-massgeschneiderte-loesungen/lieferantenportal/lieferantenmanagement/STA02-lieferantenauswahl.jpg?db=web&mw=479&w=996&hash=96A591DBA07A2449D1F1B973D587F3B0%202x');
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>