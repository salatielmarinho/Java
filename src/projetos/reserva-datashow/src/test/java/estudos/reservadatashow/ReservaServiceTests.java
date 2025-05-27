package estudos.reservadatashow;

import application.model.Reserva;
import application.repository.ReservaRepository;
import application.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarReserva() {
        Reserva reserva = new Reserva();

        reserva.setNomeProfessor("João");
        reserva.setDataReserva(LocalDate.parse("2025-05-27"));
        reserva.setSala("Lab 3");
        reserva.setHorarioInicio(LocalTime.parse("10:00"));
        reserva.setHorarioFim(LocalTime.parse("11:00"));
        reserva.setObservacoes("Precisa de adaptador HDMI");

        when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reserva resultado = reservaService.salvar(reserva);

        assertNotNull(resultado);
        verify(reservaRepository).save(reserva);
    }

    @Test
    void deveListarTodasAsReservas() {
        List<Reserva> reservas = Arrays.asList(new Reserva(), new Reserva());
        when(reservaRepository.findAll()).thenReturn(reservas);

        List<Reserva> resultado = reservaService.listarTodas();

        assertEquals(2, resultado.size());
        verify(reservaRepository).findAll();
    }

    @Test
    void deveVerificarSeReservaExistePorId() {
        when(reservaRepository.existsById(1L)).thenReturn(true);

        boolean existe = reservaService.existePorId(1L);

        assertTrue(existe);
        verify(reservaRepository).existsById(1L);
    }

    @Test
    void deveDeletarReservaPorId() {
        Long id = 1L;

        reservaService.deletar(id);

        verify(reservaRepository).deleteById(id);
    }
}