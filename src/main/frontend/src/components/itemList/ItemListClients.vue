<template>
  <v-container>
  <v-layout row wrap>
  <v-card
    class="mx-auto" style="width: 55%; ">
    <v-toolbar
      color="#13077d" dark>
      <v-text-field
        hide-details
        prepend-icon="mdi-magnify"
        single-line/>
      <v-spacer/>
      <v-btn class="indigo">Search</v-btn>
      <v-app-bar-nav-icon  @click="drawer = !drawer"/>
    </v-toolbar>

    <v-list two-line>
      <v-list-item-group
        v-model="selected"
        active-class="indigo--text"
        multiple>
        <template v-for="(item, id) in items">
          <v-list-item :key="item.id">
            <template>  
              <v-list-item-content>
                  <v-list-item-subtitle v-text="item.name+' '+item.lastName+', '+item.phoneNumber+', '+item.address+', '+item.email"></v-list-item-subtitle>
              </v-list-item-content>
            </template>
          </v-list-item>
          <v-divider v-if="id <items.length-1" :key="id"/>
        </template>
      </v-list-item-group>
    </v-list>
  </v-card>
  <v-card v-bind:class="{'cardClass':drawer}" width="15%" height="auto">
    <div>
      <h2>Sort by</h2>
    </div>
    <v-divider></v-divider>
    <v-list-item>
      <v-checkbox label="Name"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Last name"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Phone number"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Address"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Email"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Date of examination"></v-checkbox>
    </v-list-item>
  </v-card>
  
  </v-layout>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      drawer: true,
    }),
    props: [
        "items"
    ]
  }
</script>

<style scoped>
.cardClass {
  display: none; 
}
</style>