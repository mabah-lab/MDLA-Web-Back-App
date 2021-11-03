package mdla.dara.web;

import mdla.dara.dao.MembreRepository;
import mdla.dara.entities.Membre;
import mdla.dara.services.ImplemMembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Paths.get;

@CrossOrigin("*")
@RestController
public class MembreRestController {
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private ImplemMembreService implemMembreService;

    public MembreRestController(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }
    /*@GetMapping(path = "/photoMembre/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Membre mbre= membreRepository.findById(id).get();
        return  Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Documents/Holbah/photosApp/dara/"+mbre.getPhotoName()));
    }*/
    @GetMapping(path = "/photoMembre/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Membre mbre= membreRepository.findById(id).get();
        Path imagePath= get(System.getProperty("user.home")+"/Documents/Holbah/photosApp/dara/"+mbre.getPhotoName());
        if(!Files.exists(imagePath)){
            throw new FileNotFoundException(mbre.getPhotoName()+" non trouvé");
        }
        return  Files.readAllBytes(imagePath);
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file,@PathVariable("id") Long id) throws Exception{
        Membre mbre= membreRepository.findById(id).get();
        mbre.setPhotoName(id+".png");
        Files.write(get(System.getProperty("user.home")+"/Documents/Holbah/photosApp/dara/"+id+".png"),file.getBytes());
        membreRepository.save(mbre);
    }
    @PostMapping(path = "/addMembre")
    public void NewMembre(@RequestBody Membre membre){
        implemMembreService.addMembre(membre);
    }
}
