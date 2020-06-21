import axios from 'axios'
import router from '@/router'

const state = {
    context : 'http://localhost:5000',
    searchWord : 'null',
    pager : {},
    list : [],
    pages: []
}

const actions = {
    async search({commit},payload){
        axios.get(`${state.context}/${payload.cate}/findSome/${payload.searchWord}/${payload.pageNum}`)
            .then(({data})=>{
                state.list = data.list
                state.pager = data.pager
                state.searchWord = payload.searchWord
                state.pages = []
                alert(data.pager.pageEnd)
                let i = data.pager.pageStart
                for(; i <= data.pager.pageEnd ; i++ ){
                    state.pages.push(i + 1)
                }
                alert(state.pages)
                commit('SEARCH')
            })
            .catch(()=>{
                alert('commit fail :(')
            })
    },
    async transferSome({commit},payload) {
        axios.get(`${state.context}/${payload.cate}/findSome/${state.searchWord}/${payload.pageNum}`)
            .then(({data})=>{
                state.list = data.list
                state.pager = data.pager
                state.pages = []
                let i = data.pager.pageStart
                for(; i <= data.pager.pageEnd ; i++ ){
                    state.pages.push(i + 1)
                }
                commit()
            })
            .catch(()=>{})
    },
    async findAll({commit}, payload){
        axios.get(`${state.context}/${payload.cate}/findAll/${payload.pageNum}`)
            .then(({data})=>{
                state.list = data.list
                state.pager = data.pager
                let i = data.pager.pageStart
                for(; i <= data.pager.pageEnd ; i++ ){
                    state.pages.push(i + 1)
                }
                commit('FINDALL')
            })
            .catch(()=>{})
    },
    async transfer({commit},payload){
        alert(payload.pageNum)
        axios.get(`${state.context}/${payload.cate}/findAll/${payload.pageNum}`)
            .then(({data})=>{
                state.list = data.list
                state.pager = data.pager
                let i = data.pager.pageStart
                state.pages = []
                for(; i <= data.pager.pageEnd ; i++ ) {
                    state.pages.push(i + 1)
                }
                commit()
            })
            .catch(()=>{})
    }
}

const mutations = {
    SEARCH(){
        router.push('/fifTeenSome')
    },
    FINDALL(){
        router.push('/fifteen')
    }
}

const getters = {

}

export default {
    name : 'picnic',
    namespaced : true,
    state, actions, mutations, getters
}