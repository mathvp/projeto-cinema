<template>
  <div id="app">
    <MainNav />
    <router-view/>
  </div>
</template>
<script>
  require('@/assets/css/style.css')
  import MainNav from '@/components/MainNav.vue'

  export default {
    components : {
      MainNav
    }
  }
</script>

<style>

</style>
