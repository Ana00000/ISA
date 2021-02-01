<template>
  <v-container>
  <v-layout row wrap>
  <v-card
    class="mx-auto" style="width: 70%"
  >
    <v-toolbar
      color="#3949AB"
      dark
    >

      <!-- <v-toolbar-title>{{title}}</v-toolbar-title> -->
      <v-text-field
        hide-details
        prepend-icon="mdi-magnify"
        single-line
      ></v-text-field>

      <v-spacer></v-spacer>

      <v-app-bar-nav-icon  @click="drawer = !drawer"></v-app-bar-nav-icon>

    </v-toolbar>

    <v-list two-line>
      <v-list-item-group
        v-model="selected"
        active-class="pink--text"
        multiple
      >
        <template v-for="(item, index) in items">
          <v-list-item :key="item.title">
            <template v-slot:default="{ active }">
              <v-list-item-content>
                <v-list-item-title v-text="item.title"></v-list-item-title>

                <!-- <v-list-item-subtitle
                  class="text--primary"
                  v-text="item.headline"
                ></v-list-item-subtitle> -->

                <!-- <v-list-item-subtitle v-text="item.subtitle"></v-list-item-subtitle> -->
              </v-list-item-content>

              <v-list-item-action>
                <v-list-item-action-text v-text="item.action"></v-list-item-action-text>

                <v-icon
                  v-if="!active"
                  color="grey lighten-1"
                >
                  mdi-star-outline
                </v-icon>

                <v-icon
                  v-else
                  color="yellow darken-3"
                >
                  mdi-star
                </v-icon>
              </v-list-item-action>
            </template>
          </v-list-item>

          <v-divider
            v-if="index < items.length - 1"
            :key="index"
          ></v-divider>
        </template>
      </v-list-item-group>
    </v-list>
  </v-card>
  <v-card v-bind:class="{'cardClass':drawer}" width="30%">
    <div>
      <h2>Sort criteria</h2>
    </div>
    <v-divider></v-divider>
    <v-list-item>
      <v-checkbox label="Name"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Address"></v-checkbox>
    </v-list-item>
    <v-list-item>
      <v-checkbox label="Grade"></v-checkbox>
    </v-list-item>
    <v-btn>Search</v-btn>
  </v-card>
  
  <!-- <v-navigation-drawer
      v-model="drawer"
      temporary
    >
      <v-list
        nav
        dense
      >
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item>
            <v-list-item-title>Foo</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Bar</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Fizz</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Buzz</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer> -->
  </v-layout>
  </v-container>
</template>


<script>
  export default {
    data: () => ({
      selected: [2],
      items: [] /*userId, id, title*/ ,
      drawer: false,
    }),
    props: [
        "title",
        "items"
    ]
  }
</script>

<style scoped>
.cardClass {
  display: none; 
}
</style>