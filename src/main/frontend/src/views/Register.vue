<template>
    <div>
        <div>
        <h1>Register</h1>
        </div>
        <div>
            <div class="grid-container">
                <h3 >
                    Name
                </h3>
                <textarea />
                <h3 >
                    Last name
                </h3>
                <textarea />
                <h3 >
                    Role
                </h3>    
                <textarea />    
                <h3 >
                    Date of birth
                </h3>    
                <textarea />
                <h3 >
                    E-Mail
                </h3>    
                <textarea />
                <h3 >
                    Address
                </h3>    
                <textarea />     
            </div>
            <button class="button-base" > Confirm registration</button>
        </div>
    </div>
</template>

<script>


</script>

<style scoped>

.grid-container {
    display: grid;
    grid-template-columns: auto auto;
    grid-template-rows: 200 200 200 200 200 200;
    grid-gap: 10px;
    background-color: rgb(44,62,80);
    color: #42b983;
    padding: 10px;
}

.button-base {
  background-color: #42b983; /* Green */
  border: none;
  color: rgb(44,62,80);
  padding: 15px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 32px;
  font-weight: bold;
  margin: 4px 2px;
  cursor: pointer;

}

.button-confirm_registration {
    background-color: #42b983;
    color: rgb(44,62,80);
}

</style>