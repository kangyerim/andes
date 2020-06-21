<template>
    <div id="background">
        <div v-if="auth">
        <table class="header">
            <tr>
                <td><router-link to="/"><h1 class="project_name">FIF TEEN🚴</h1></router-link></td>
                <td class="td2"></td>
                <td>
                    <div class="top">
                        <a>마이페이지</a>
                        <a @click="logout">로그아웃</a>
                    </div>
                </td>
            </tr>
        </table>
        </div>

        <div v-else>
        <table class="header">
            <tr>
                <td><router-link to="/"><h1 class="project_name">FIF TEEN🚴</h1></router-link></td>
                <td class="td2"></td>
                <td>
                    <div class="top">
                        <a><router-link to="/signup">회원가입</router-link></a>
                        <a><router-link to="/login">로그인</router-link></a>
                    </div>
                </td>
            </tr>
        </table>
        </div>
    </div>
</template>


<script>
    import {mapState} from 'vuex'
    export default {
        computed : {
            ...mapState({
                auth : state => state.member.auth
            })
        },
        methods: {
            logout(){
                this.$store.dispatch('member/logout')
            }
        }
    }
</script>

<style scoped>
    #background{
        background-color: #b6eb7a;
    }
    .top{
        margin: 5px 5px;
        float: right;
    }
    .project_name{
        text-align: center;
        color: #1D56F0;
    }

    .td2{
        width : 490px;
    }

    .header{
        margin: 0 auto;
        padding-top : 6px;
    }
    a{
        text-decoration: none;
        font-size: 10.5pt;
        margin: 0px 10px;
        color: #ffffff;
    }
    a:hover{
        text-decoration: underline;
    }
</style>