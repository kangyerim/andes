import Vue from 'vue'
import vuex from 'vuex'
import member from "./member";
import picnic from "./picnic";

Vue.use(vuex)

export const store = new vuex.Store({
    modules : {
        member, picnic
    }
})