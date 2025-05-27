package estudos.reservadatashow;

import application.controller.ReservaController;
import application.model.Reserva;
import application.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservaControllerTest {
    private ReservaService service;
    private ReservaController controller;

    @BeforeEach
    void setUp() {
        service = mock(ReservaService.class);
        controller = new ReservaController(service);
    }

    @Test
    void deveListarTodasAsReservas() {
        Reserva reserva = new Reserva();
        when(service.listarTodas()).thenReturn(List.of(reserva));

        List<Reserva> resultado = controller.listar();

        assertEquals(1, resultado.size());
        verify(service).listarTodas();
    }

    @Test
    void deveBuscarReservaPorIdQuandoExistente() {
        Reserva reserva = new Reserva();
        reserva.setNomeProfessor("João");

        when(service.buscarPorId(1L)).thenReturn(Optional.of(reserva));

        ResponseEntity<Reserva> resposta = controller.buscar(1L);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(reserva, resposta.getBody());
    }

    @Test
    void deveRetornarNotFoundQuandoReservaNaoExistir() {
        when(service.buscarPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<Reserva> resposta = controller.buscar(1L);

        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void deveCriarReservaComSucesso() {
        Reserva reserva = new Reserva();
        reserva.setNomeProfessor("João");

        when(service.salvar(reserva)).thenReturn(reserva);

        ResponseEntity<Reserva> resposta = controller.criar(reserva);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("João", resposta.getBody().getNomeProfessor());
    }

    @Test
    void deveAtualizarReservaQuandoExistente() {
        Reserva existente = new Reserva();
        existente.setNomeProfessor("Antigo");

        Reserva nova = new Reserva();
        nova.setNomeProfessor("Novo");
        nova.setDataReserva(LocalDate.now());
        nova.setHorarioInicio(LocalTime.of(10, 0));
        nova.setHorarioFim(LocalTime.of(12, 0));
        nova.setSala("101");
        nova.setObservacoes("Atualizado");

        when(service.buscarPorId(1L)).thenReturn(Optional.of(existente));
        when(service.salvar(any(Reserva.class))).thenReturn(existente);

        ResponseEntity<Reserva> resposta = controller.atualizar(1L, nova);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("Novo", resposta.getBody().getNomeProfessor());
        verify(service).salvar(existente);
    }

    @Test
    void deveRetornarNotFoundAoAtualizarReservaInexistente() {
        when(service.buscarPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<Reserva> resposta = controller.atualizar(1L, new Reserva());

        assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void deveDeletarReservaQuandoExistente() {
        when(service.existePorId(1L)).thenReturn(true);

        ResponseEntity<Void> resposta = controller.deletar(1L);

        assertEquals(204, resposta.getStatusCodeValue());
        verify(service).deletar(1L);
    }

    @Test
    void deveRetornarNotFoundAoDeletarReservaInexistente() {
        when(service.existePorId(1L)).thenReturn(false);

        ResponseEntity<Void> resposta = controller.deletar(1L);

        assertEquals(404, resposta.getStatusCodeValue());
        verify(service, never()).deletar(anyLong());
    }
}