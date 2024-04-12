<script>
import navbar2 from "@/components/navbar2.vue"
import Todo from "@/components/Todo.vue"
import { mapState, mapActions } from 'pinia'
import { useJugadoresAPIStore } from '@/stores/jugadoresAPI'

export default {
  components: { navbar2, Todo },
  data() {
    return {}
  },
  computed: {
    ...mapState(useJugadoresAPIStore, ['jugadores'])
  },
  methods: { ...mapActions(useJugadoresAPIStore, ['cargarJugadores']) },
  mounted() {
    this.cargarJugadores();
  }
}
</script>

<template>
  <div class="container">
    <div>
      <navbar2></navbar2>
    </div>
    <div class="container">
      <h1 class="titulo p-4">Listado de Jugadores</h1>

      <ul>
        <li v-for="jugador in jugadores" :key="jugador._links.self.href">
          <Todo :jugadoresprop="jugador"></Todo>
        </li>
      </ul>
    </div>
    <div class="centrar">
      <button type="button" class="btn btn-success" @click="abrirModalNuevoPartido">Añadir Jugador</button>
    </div>
  </div>
</template>

<style scoped>
.centrar {
  text-align: center;
  /* Alinear horizontalmente */
}
</style>