<template>
  <div class="home">
    <h1>Filmes em Cartaz</h1>
    <MoviesList />
  </div>
</template>

<script>
// @ is an alias to /src
import MoviesList from '@/components/MoviesList.vue'

export default {
  name: 'home',
  components: {
    MoviesList
  }
}
</script>
