<template>
  <div class="movies container">
    <h1>{{movieInfo.titulo}}</h1>
    <div class="movie-info content">
      <div class="movie-img">
        <img src="http://templatelab.com/wp-content/uploads/2019/06/movie-poster-template-10.jpg" alt="">
      </div>
      <div class="movie-data">
        <table>
          <tbody>
            <tr>
              <td>Duração:</td>
              <td>{{movieInfo.duracao}} min</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Movie',
  data() {
    return {
      movie_id: this.$route.params.movie_id,
      movieInfo: {}
    }
  },
  created() {
    axios.get(process.env.VUE_APP_API_URL+'/filmes/'+this.movie_id)
    .then(response => {
      this.movieInfo = response.data
    })
  }
}
</script>

<style>
  .movie-info {
    display: grid;
    grid-template-columns: 1fr 2fr;
    grid-column-gap: 60px;
    align-items: center;
  }
  .movie-info img {
    width: 100%;
  }
</style>

