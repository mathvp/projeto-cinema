<template>
  <div class="movies-table content">
    <table v-if="moviesList">
      <thead>
        <tr>
          <th>#</th>
          <th>Título</th>
          <th>Duração</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="movie in filteredMovies" :key="movie.id" :id="movie.id">
          <td class="text-center">
            <router-link :to="{ name: 'movieShow', params: { movie_id: movie.id } }">{{movie.id}}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'movieShow', params: { movie_id: movie.id } }">{{movie.titulo}}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'movieShow', params: { movie_id: movie.id } }">{{movie.duracao}}</router-link>
          </td>
          <td>
            <router-link :to="{ name: 'movieShow', params: { movie_id: movie.id } }">{{movie.status}}</router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'MoviesTable',
  data() {
    return {
      moviesList: [],
      searchTerm: ''
    }
  },
  created() {
  },
  mounted() {
    axios.get(process.env.VUE_APP_API_URL+'/filmes')
    .then(response => {
      this.moviesList = response.data
    })
  },
  computed: {
    filteredMovies() {
      if(this.searchTerm === ''){
        return this.moviesList
      }
      return Array.from(this.moviesList).filter(movie => {
        return movie.titulo.toLowerCase().match(this.searchTerm.toLowerCase())
      })
    }
  }
}
</script>

<style>
  
</style>

