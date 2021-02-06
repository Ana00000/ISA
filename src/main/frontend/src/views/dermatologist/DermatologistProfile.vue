<template>
    <div style="
        background: #13077d;
        background: -webkit-linear-gradient(to right, #5442ed, #cdc8fa, #13077d);
        background: linear-gradient(to right, #5442ed, #cdc8fa, #13077d);">

        <div class="pagePlacing">
            <br/><br/>
            
            <div class="userImage">
                <img :src="userImage" width="600px" height="500px"/>
            </div>

            <v-container fluid class="container">
                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                        label="Name"
                        v-model="name"
                        hint="Your name should contain at least 2 characters!"/>
                </v-col>
                </v-row>

                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                    label="Last name"
                    v-model="lastName"
                    hint="Your last name should contain at least 2 characters!"/>
                </v-col>
                </v-row>

                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                    label="Email"
                    v-model="email"
                    hint="Your email should contain at least 5 characters!"/>
                </v-col>
                </v-row>

                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                    label="Password"
                    v-model="password"
                    hint="Your password should contain at least 3 characters!"
                    ref="password"
                    type="password"/>
                </v-col>
                </v-row>

                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                    label="Address"
                    v-model="address"
                    hint="Your address should contain at least 3 characters!"/>
                </v-col>
                </v-row>
                
                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                    label="Phone number"
                    v-model="phoneNumber"
                    hint="Your phone number should contain 9 or 10 numbers!"/>
                </v-col>
                </v-row>
                
                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                    label="Type of doctor"
                    v-model="type"
                    hint="You can not change your job title, only admin can!"
                    readonly/>
                </v-col>
                </v-row>

                <v-row>
                <v-col cols="5"/>
                <v-col cols="3">
                    <v-text-field
                    label="Working in pharmacy/pharmacies"
                    v-model="workingInPharmacy"
                    hint="You can not change in which pharmacy/pharmacies you work, only admin can!"
                    readonly>
                    </v-text-field>
                </v-col>
                </v-row>
                <br/><br/>
            </v-container>

            <div class="updatePng">
                <img :src="updatePng" width="350px" height="350px"/>
            </div>

            <div class="updateButton">
                <v-btn
                    v-on:click="updateProfile" 
                    color="#aba7ff"
                    elevation="24"
                    x-large
                    raised
                    rounded
                >Update info</v-btn>
            </div>
        </div>

        <div>
            <DermatologistMenu/>
        </div> 
    </div>  
</template>

<script>
import userImage from "../../assets/user_profile.jpg"
import updatePng from "../../assets/update_profile.png"
import DermatologistMenu from '../../components/dermatologist/DermatologistMenu.vue'
export default {
    name: 'DermatologistProfile',
    components : {   
        DermatologistMenu
    },
    data: () => ({
        id: null,
        name: '',
        lastName: '',
        email: '',
        password: '',
        address: '',
        phoneNumber: '',
        active: true,
        type: '',
        workingInPharmacy: [],
        userImage: userImage,
        updatePng: updatePng
    }),
    mounted() {
        this.init();
    },
    methods: {
        init() {
            this.setDermatologist();
            this.setPharmacy();
        },
        setDermatologist() {
            this.id = this.$route.params.id;
            this.$http.get('http://localhost:8081/dermatologists/' + this.id).then(resp => {
                console.log(resp.data);
                this.setDermatologistInfo(resp.data);
            }).catch(err => console.log(err));
        },
        setDermatologistInfo(item) {
            this.id = item.id;
            this.name = item.name;
            this.lastName = item.lastName;
            this.email = item.email;
            this.password = item.password;
            this.address = item.address;
            this.phoneNumber = item.phoneNumber;
            this.type = item.type;
            this.active = item.active;
        },
        setPharmacy() {
            this.$http.get('http://localhost:8081/pharmacies/all').then(resp => {
                console.log(resp.data);
                this.setPharmacyInfo(resp.data);
            }).catch(err => console.log(err));
        },
        setPharmacyInfo(item) {
            item.forEach(pharmacy => {
                pharmacy.dermatologists.forEach(dermatologist => {
                    if(dermatologist.id == this.id) 
                        this.workingInPharmacy.push(pharmacy.id);
                });

            });
        },
        updateProfile() {
            this.validationOfInput();
            this.$http.put('http://localhost:8081/dermatologists/update', 
            {         
                id : this.id,
                name : this.name,
                lastName : this.lastName,
                email : this.email,
                password : this.password,
                address : this.address,
                phoneNumber : this.phoneNumber,
                active : this.active,
                type : this.type,
                hashString: null
            }
            ).then(resp => {
               console.log(resp.data);
            }).catch(err => console.log(err));
        },
        validationOfInput() {
            this.validationOfName();
            this.validationOfLastName();
            this.validationOfEmail();
            this.validationOfPassword();
            this.validationOfAddress();
            this.validationOfPhoneNumber();
        },
        validationOfName() {
            if(this.name.length < 2)
            {
                alert("Your name should contain at least 2 characters!");
                return;
            }else if(this.name.length > 20)
            {
                alert("Your name shouldn't contain more than 20 characters!");
                return;
            }
        },
        validationOfLastName() {
            if(this.lastName.length < 2)
            {
                alert("Your last name should contain at least 2 characters!");
                return;
            }else if(this.lastName.length > 20)
            {
                alert("Your last name shouldn't contain more than 20 characters!");
                return;
            }
        },
        validationOfEmail() {
            if(this.email.length < 5)
            {
                alert("Your email should contain at least 5 characters!");
                return;
            }else if(this.email.length > 35)
            {
                alert("Your email shouldn't contain more than 35 characters!");
                return;
            }
        },
        validationOfPassword() {
            if(this.password.length < 3)
            {
                alert("Your password should contain at least 3 characters!");
                return;
            }else if(this.password.length > 20)
            {
                alert("Your password shouldn't contain more than 20 characters!");
                return;
            }
        },
        validationOfAddress() {
            if(this.address.length < 3)
            {
                alert("Your address should contain at least 3 characters!");
                return;
            }else if(this.address.length > 50)
            {
                alert("Your address shouldn't contain more than 50 characters!");
                return;
            }
        },
        validationOfPhoneNumber() {
            this.validationOfPhoneNumberLength();
            this.validationOfPhoneNumberElements();
        }, 
        validationOfPhoneNumberLength() {
            if(this.phoneNumber.length < 6)
            {
                alert("Your phone number should contain at least 6 characters!");
                return;
            }else if(this.phoneNumber.length > 10)
            {
                alert("Your phone number shouldn't contain more than 10 characters!");
                return;
            }
        },
        validationOfPhoneNumberElements() {
            var keysAllowed = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '/', '-'];
            for(var element = 0; element < this.phoneNumber.length; element++)
            {
                if(!keysAllowed.includes(this.phoneNumber[element]))
                {
                    alert("Your phone number can contain only numbers and / - characters!");
                    return;
                }
            }
        }
    }
}
</script>

<style scoped>
.pagePlacing {
    height: 840px;
}

.userImage {
    position: absolute;
    left: 110px;
    top: 150px;
}

.updatePng {
    position: absolute;
    right: 160px;
    top: 100px;
}

.updateButton {
    position: absolute;
    right: 250px;
    top: 600px;
}
</style>