package application.controller;

import application.model.Reserva;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import application.service.ReservaService;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva) {
        Reserva salva = service.salvar(reserva);
        return ResponseEntity.ok(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id, @RequestBody Reserva novaReserva) {
        return service.buscarPorId(id)
                .map(reserva -> {
                    reserva.setNomeProfessor(novaReserva.getNomeProfessor());
                    reserva.setDataReserva(novaReserva.getDataReserva());
                    reserva.setHorarioInicio(novaReserva.getHorarioInicio());
                    reserva.setHorarioFim(novaReserva.getHorarioFim());
                    reserva.setSala(novaReserva.getSala());
                    reserva.setObservacoes(novaReserva.getObservacoes());
                    Reserva atualizada = service.salvar(reserva);
                    return ResponseEntity.ok(atualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.existePorId(id)) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}