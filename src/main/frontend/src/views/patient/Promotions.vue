<template>
    <v-container style="padding: 0px" fluid fill-height dark >
        <v-layout>
            <div style="width:25%;">
                <PatientMenu/>
            </div>
            <div class="panelDiv" style="width:75%;">
                <div style="margin: 50px"><h2 class="display-3">Promotions</h2></div>
                <div style="background: none; border: none;">
                    <item-list-promotions></item-list-promotions>
                </div>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import PatientMenu from '@/components/PatientMenu.vue'
import ItemListPromotions from '../../components/itemList/ItemListPromotions.vue'
export default {
    name : 'Promotions',
    components : {
        PatientMenu,
        ItemListPromotions
    },
    data() {
        return {
        }
    },
}
</script>

<style scoped>

.panelDiv {
    width: 100%;
    margin: 0 auto;
    background: none;
    border: none;
}
</style>