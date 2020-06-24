import axios from 'axios'
import router from '../router'

const state = {
    context : 'http://localhost:5000',
    login : sessionStorage.getItem("login"),
    member : sessionStorage.getItem("userId"),
    fail : false,
    duplication : false,
    auth : false,
    user : {}
}

const actions = {
    async submission({commit}, payload){
        axios.post(`${state.context}/members/signin`,payload ,{
                authorization: "JWT fefege..",
                Accept: "application/json",
                "Content-Type": "application/json"})
            .then(()=>{
                commit('SUCCESS')
                alert('가입성공 :)')
            })
            .catch(()=>{
                alert('member.js 의 submission actions 실패')
            })
    },
    async login({commit},payload){
        axios.post(`${state.context}/members/login`,payload,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            "Content-Type": "application/json"})
            .then(({data})=>{
                commit('LOGIN',data)
                router.push('/')
                alert('로그인 성공')
            })
            .catch(()=>{
                alert('member.js의 login catch')
            })
    },
    logout({commit}){
        commit('LOGOUT')
        router.push('/').catch(() => {})
    }
}

const mutations = {
    LOGIN(state, data){
       if(data.result === 'true'){
           state.fail = false
           state.auth = true
           sessionStorage.setItem('login', 'true')
           sessionStorage.setItem('userId', data.member.userId)
       } else {
            state.fail = true
       }
    },
    LOGOUT(state){
        state.auth = false
        sessionStorage.removeItem('login')
        sessionStorage.removeItem('userId')
    },
    SUCCESS(){
        router.push('/').catch()
    }
}

export default {
    name : 'member',
    namespaced : true,
    state, actions, mutations
}
