<template>
    <div>
        <v-simple-table class="table">
            <thead>
            <tr>
                <th class="text-left">FIF TEEN STATION</th>
                <th class="text-left">ADDRESS</th>
                <th class="text-left">RentableNum</th>
                <th class="text-left">ReturnableNum</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="item of list" :key="item.name">
                <td>{{ item.stationName }}</td>
                <td>{{ item.branchAddress }}</td>
                <td>{{ item.holdingNum }}</td>
                <td>{{ item.holderNum }}</td>
            </tr>
            </tbody>
        </v-simple-table>

        <table style="margin: 0 auto; width:500px; height: 100px;">
            <tr>
                <td>
                    <span @click="transferPage(pager.pageStart-1)" v-if="pager.existPre">이전</span>
                </td>
                <td @click="transferPage(pageNum-1)" :key="pageNum" v-for="pageNum of pages">
                    <span>{{pageNum}}</span>
                </td>
                <td>
                    <span @click="transferPage(pager.nextBlock)" v-if="pager.existNext">다음</span>
                </td>
            </tr>
        </table>

    </div>
</template>


<script>
    import {mapState} from 'vuex'
    export default {
        computed : {
            ...mapState({
                list : state => state.picnic.list,
                pager : state => state.picnic.pager,
                pages:  state => state.picnic.pages
            })
        },
        methods : {
            transferPage(num) {
                this.$store.dispatch('picnic/transferSome', {cate: 'picnic', pageNum: num})
            }
        }
    }
</script>

<style scoped>
    .table tr td {
        text-align: center;
    }
</style>