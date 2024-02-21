package sn.esmt.produit.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.produit.entity.ProduitEntity;
import sn.esmt.produit.service.ProduitService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produits")
@AllArgsConstructor
public class ProduitController {
  private ProduitService produitService;
  @PostMapping
  public ProduitEntity save(ProduitEntity produitEntity){
    return produitService.save(produitEntity);
  }
  @GetMapping
  public List<ProduitEntity> all(){
    return produitService.getAll().get();
  }
  @GetMapping("/{ref}")
  public Optional<ProduitEntity> get(@PathVariable String ref){return produitService.get(ref);}

  @PutMapping("/{ref}")
  public ProduitEntity update(String ref, ProduitEntity produitEntity){return produitService.update(ref,produitEntity);}
  @DeleteMapping("/{ref}")
  public void delete(@PathVariable String ref){produitService.delete(ref);}
}
