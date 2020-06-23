import Vue from 'vue'
import router from 'vue-router'
import HelloWorld from "../components/HelloWorld";
import SignUp from '../components/SignUp'
import LogIn from "../components/LogIn";
import FifTeen from "../components/FifTeen";
import FifTeenSome from "../components/FifTeenSome";
import MyPage from "../components/MyPage";

Vue.use(router)

export default new router({
    mode : 'history',
    base : process.env.BASE_URL,
    routes : [
        {path : '/', component : HelloWorld},
        {path : '/signup', component: SignUp},
        {path : '/login', component: LogIn},
        {path : '/fifteen', component: FifTeen},
        {path : '/fifTeenSome', component: FifTeenSome},
        {path : '/myPage', component: MyPage}
    ]
})