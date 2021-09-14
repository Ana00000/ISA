<template>
    <div>
        <p v-if="this.isItVerified">You have verified profile !!!</p>
        <p v-else>You have alredy verifed your profile</p>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
        return{
            hash:"",
            isItVerified:false
        }
    },
    created(){
        this.hash =  this.$route.params.hash;
        console.log(this.hash);
        axios.post('http://localhost:8081/users/verify/' + this.hash)
                .then(() => {
                this.isItVerified= true;
            })
          .catch(err => console.log(err));
    }
}
</script>

<style>

</style>