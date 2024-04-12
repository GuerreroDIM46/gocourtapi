<script>
export default {
    props: ['jugadoresprop'],
    emits: [],
    methods: {}
}

</script>

<template>
    <div class="jugador">
        {{ jugadoresprop.nombre }}
    </div>

</template>


<style scoped>
.jugador {
    border: solid;
}

.icono-fontawesome {
    cursor: pointer;
    transition: transform 0.2s ease;
}

.icono-fontawesome:hover {
    transform: scale(1.5);
}
</style>