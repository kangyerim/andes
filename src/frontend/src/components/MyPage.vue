<template>
    <div>
        <v-tabs>
            <v-tab>즐겨찾는 피프틴파크</v-tab>
            <v-tab>내 정보</v-tab>
        </v-tabs>
        <div style="margin: 0 auto; width: 50%">
            <v-form>
                <table class="login_input">
                    <tr><v-col cols="12" md="4" >{{login.userId}}
                        <v-text-field
                                class="justify-center"
                                v-model=userId
                                label="아이디"
                                required
                        ></v-text-field>
                    </v-col></tr>
                    <tr><v-col
                            cols="12"
                            md="4"
                    >
                        <v-text-field
                                v-model=password
                                label="패스워드"
                                required
                        ></v-text-field>
                    </v-col></tr>
                    <tr><v-col cols="12"
                               md="4">
                        <v-text-field
                                v-model=userName
                                label="이름"
                                required
                        ></v-text-field>
                    </v-col></tr>
                    <tr><v-col
                            cols="12"
                            md="4"
                    >
                        <v-text-field
                                v-model=address
                                label="주소"
                                required
                        ></v-text-field>
                    </v-col></tr>
                </table>
            </v-form>
        </div>

        <div style="margin: 0 auto; width: 30%">
            <v-btn >돌아가기</v-btn>
            <span style="padding-right: 30px"></span>
            <v-btn >수  정</v-btn>
            <span style="padding-right: 30px"></span>
            <v-btn>탈  퇴</v-btn>
        </div>

    </div>
</template>

<script>
    import {mapState} from 'vuex'
    export default {
        computed : {
            ...mapState({
                login : state => state.member.login
            })
        }
    }
</script>

<style scoped>
    .buttons{
        text-align: center;
    }
    .login_input{
        width: 1200px;
        color: #ffffff;
        text-align: center;
        margin: 0 auto;
    }
</style>