<template>
    <div style="margin: 0 auto; width: 50%">
        <v-form>
            <table class="login_input">
                <tr><v-col cols="12" md="4" >
                    <v-text-field
                            v-model=userId
                            :rules="idRules"
                            :counter="20"
                            label="아이디"
                            required
                    ></v-text-field>
                </v-col></tr>
                <tr><v-col cols="12" md="4">
                    <v-text-field
                            v-model=password
                            :rules="passRules"
                            :counter="20"
                            label="패스워드"
                            required
                    ></v-text-field>
                </v-col></tr>
            </table>
        </v-form>

        <div class="buttons">
            <v-btn @click="reset()">다시작성</v-btn>
            <span style="padding-right: 30px"></span>
            <v-btn @click="login">로그인</v-btn>
        </div>

    </div>
</template>

<script>
    export default {
        data: () => ({
            valid: false,
            userId: '',
            idRules : [
                v => !!v || 'userId is required',
                v => v.length <= 10 || 'userId must be less than 10 characters',
            ],
            password: '',
            passRules: [
                v => !!v || 'password is required',
                v => v.length <= 10 || 'Name must be less than 10 characters',
            ],
        }),
        methods: {
            login() {
                this.$store.dispatch('member/login',{password : this.password, userId : this.userId})
            },
            reset() {
                this.password = ''
                this.userId = ''
            },
        }
    }
</script>

<style scoped>
    .buttons{
        text-align: center;
    }
    .login_input{
        width: 1200px;
    }

</style>