<template>
  <div class="movies container">
    <h1>Lista de Filmes</h1>
    <MoviesTable />
  </div>
</template>

<script>

import MoviesTable from '@/components/MoviesTable'

export default {
  name: 'Movies',
  components: {
    MoviesTable
  }
}
</script>
