package proyect.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyect.bean.Empresa;
import proyect.bean.OfertaTreball;
import proyect.repository.EmpresaRepository;
import proyect.repository.OfertaTreballRepository;

@RestController
@RequestMapping("/empresas")
public class Controlador {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> consultarEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            return ResponseEntity.ok(empresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empresa> agregarEmpresa(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> modificarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Optional<Empresa> empresaExistente = empresaRepository.findById(id);
        if (empresaExistente.isPresent()) {
            empresa.setId(id);
            Empresa empresaActualizada = empresaRepository.save(empresa);
            return ResponseEntity.ok(empresaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresaExistente = empresaRepository.findById(id);
        if (empresaExistente.isPresent()) {
            empresaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RestController
    @RequestMapping("/ofertes")
    public class OfertaTreballController {
        @Autowired
        private OfertaTreball ofertaTreballRepository;

        public OfertaTreballController(OfertaTreball ofertaTreballRepository) {
            this.ofertaTreballRepository = ofertaTreballRepository;
        }

        @PostMapping
        public OfertaTreball afegirOfertaTreball(@RequestBody OfertaTreball ofertaTreball) {
            return ofertaTreballRepository.save(ofertaTreball);
        }

        @GetMapping
        public List<OfertaTreball> consultarOfertes() {
            return ofertaTreballRepository.findAll();
        }

        @GetMapping("/empresa/{id}")
        public List<OfertaTreball> consultarOfertesPerEmpresa(@PathVariable Long id) {
            return ofertaTreballRepository.findByEmpresaId(id);
        }

        @PutMapping("/{id}")
        public OfertaTreball actualitzarOfertaTreball(@PathVariable Long id, @RequestBody OfertaTreball ofertaTreball) {
            ofertaTreball.setId(id);
            return ofertaTreballRepository.save(ofertaTreball);
        }

        @DeleteMapping("/{id}")
        public void eliminarOfertaTreball(@PathVariable Long id) {
            ofertaTreballRepository.deleteById(id);
        }
    }


}

