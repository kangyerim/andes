<template>
  <div id="background">
    <div>
      <table class="searches">
        <tr>
          <td></td>
          <td><a class="introduction">🐈 고양시 공공자전거 서비스 🚴</a><br>
            <a class="introduction">피프틴 스테이션에 자전거가 몇 개 남았는지 확인하자</a><br>
            <a  class="introduction" @click="findAll">전체 스테이션 보기</a></td>
          <td></td>
        </tr>
        <tr>
          <td><span style="padding-right : 300px;"></span></td>
          <td><input v-model="searchWord" id="search" type="text" value="주소 입력"></td>
          <td><input @click="search" id="search_bar" type="button" value="검색"></td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        searchWord : ""
      }
    },
    methods : {
      search(){
        let searchWord = document.getElementById('search').value
        if(searchWord === '') searchWord = 'null'
        this.$store.dispatch('picnic/search', {cate: 'picnic', searchWord : searchWord, pageNum : 0})
      },
      findAll(){
        this.$store.dispatch('picnic/findAll', {cate: 'picnic', pageNum:0})
      }
    }
  }
</script>

<style scoped>
  #background{
    background-color: #b6eb7a;
  }
  body{
    margin: 0px;
    min-width: 1050px;
    min-height: 700px;

  }

  img{
    margin: 10px 7px;
    width: 20px;
    vertical-align: middle;
  }
  a{
    text-decoration: none;
    font-size: 10.5pt;
    margin: 0px 10px;
    color: #ffffff;
  }
  #search{
    display: block;
    margin: 0 auto;
    width: 400px;
    height: 40px;
    font-size: 15pt;
    box-shadow: 3px 3px 5px #C3C3C3;
    border: 1px solid #EAEAEA;
    background-color: #ffffff;
  }
  #search_bar{
    width: 80px;
    height: 40px;
    margin: 30px 3px;
    border: none;
    background-color: #F4F4F4;
    font-weight: bold;
    color: grey;
  }
  .introduction{
    font-size: 20px;
    text-align: center;
    color: #1D56F0;
  }
  .searches{
    text-align: center;
  }


</style>