<template>
    <div>
        <h1>Login</h1>
    </div>
    <div>
        <div class="grid-container">
            <h3 >
                E-Mail
            </h3>
            <input class="textarea-base"/>
            <h3 >
                Password
            </h3>
            <input type="Password" class="textarea-base"/>  
        </div>
        <button class="button-base" >Sign in</button>
    </div>
</template>

<script>


</script>

<style scoped>

.grid-container {
    display: grid;
    grid-template-columns: auto auto;
    grid-template-rows: 200 200 ;
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

.textarea-base {
    vertical-align: middle;
    font-size: 24px;
}

.textarea-password {
    vertical-align: middle;
    font-size: 24px;
    
}

</style>