<template>
  <v-content id="background">
   <Header/><br>
    <router-view/><br>
    <Footer/>
  </v-content>
</template>

<script>
  import Header from "./components/layouts/Header";
  import Footer from "./components/layouts/Footer";

  export default {
    components : {Footer, Header}
  }
</script>

<style>
  #background{
    background-color: #b6eb7a;
  }
</style>