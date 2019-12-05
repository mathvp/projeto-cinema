<template>
  <div class="movies container">
    <h1>{{roomInfo.numeroSala}}</h1>
    
    <div class="movie-info content">
      <div class="movie-img">
        <img src="../../assets/cover-placeholder.png" alt="sala">
      </div>
      <div class="movie-data">
        <table>
          <tbody>
            <tr>
              <td>Numero:</td>
              <td>{{roomInfo.numeroSala}} nº</td>
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
  name: 'Room',
  data() {
    return {
      room_id: this.$route.params.room_id,
      roomInfo: {}
    }
  },
  created() {
    axios.get(process.env.VUE_APP_API_URL+'/salas/'+this.room_id)
    .then(response => {
      console.log(response.data)
      this.roomInfo = response.data
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

