import axios from 'axios'
import router from '../router'

const state = {
    context : 'http://localhost:5000',
    auth : false,
    user : {}
}

const actions = {
    async submission({commit}, payload){
        axios.post(`${state.context}/members`,payload ,{
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
        axios.post(`${state.context}/members/${payload.userId}/login`,payload,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            "Content-Type": "application/json"})
            .then(({data})=>{
                commit('LOGIN',data)
                router.push('/')
                alert('ㄷㅏ녀왔습니다')
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
        state.auth = true
        state.user = data.member
    },
    LOGOUT(state){
        state.auth = false
        state.user = {}
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
