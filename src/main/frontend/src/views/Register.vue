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
                <textarea type="Text" class="textarea-base"/>
                <h3 >
                    Last name
                </h3>
                <textarea type="Text" class="textarea-base"/>
                <h3 >
                    Role
                </h3>    
                <textarea type="Text" class="textarea-base"/>
                <h3 >
                    Date of birth
                </h3>    
                <textarea type="Text" class="textarea-base"/>
                <h3 >
                    E-Mail
                </h3>    
                <textarea type="Text" class="textarea-base"/>
                <h3 >
                    Address
                </h3>    
                <textarea type="Text" class="textarea-base"/>
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
    grid-template-rows: 50px 50px 50px 50px 50px 50px;
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

.textarea-base {
  vertical-align: middle;
  font-size: 24px;
  border: 2px solid #42b983;
  width: 500px;
}

</style>