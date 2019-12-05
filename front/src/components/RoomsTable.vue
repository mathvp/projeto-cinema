<template>
  <div class="movies-table content">
    <table v-if="moviesList">
      <thead>
        <tr>
          <th>#</th>
          <th>Numero</th>
          <th>Capacidade</th>
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
  name: 'RoomsTable',
  data() {
    return {
      roomsList: [],
      searchTerm: ''
    }
  },
  created() {
  },
  mounted() {
    axios.get(process.env.VUE_APP_API_URL+'/rooms')
    .then(response => {
      this.roomsList = response.data
    })
  },
  computed: {
    filteredRooms() {
      if(this.searchTerm === ''){
        return this.roomsList
      }
      return Array.from(this.roomsList).filter(room => {
        return room.numeroSala.match(this.searchTerm)
      })
    }
  }
}
</script>

<style>
  
</style>

