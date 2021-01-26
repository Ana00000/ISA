<template>
    <div class="nav">
        <div class="nav1" >
            <div class="nav1">
                <h2><router-link to="/">Home</router-link></h2>    
            </div>
            <div class="nav1">
                <h2><router-link to="/about">About</router-link></h2>    
            </div>
        </div>
        <div class="nav1">
            <h1>Pharmacy system</h1>
        </div>
        <div class="nav1">
            <h2><router-link to="/login">Login/Register</router-link></h2>
        </div>
    </div>
</template>

<script>
export default {
    name: 'NavigationBar',
    props: {
        msg: String
    },
    data() {
        return {
            cat: 'Cat'
        }
    }
}
</script>

<style scoped>
.nav {
    border: solid black 2px;
}
.nav1 {
    display: inline-block;
    width: 33%;
}
/* .nav1 {
    float:left;
    width: 33%;
    border: solid black 1px;
} */
h2 {
    margin: 40px 0 0;
}
a {
    color: #42b983;
}
</style>