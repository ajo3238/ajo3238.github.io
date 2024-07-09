package capstone.code.service;

import capstone.code.domain.InhousePart;
import capstone.code.domain.OutsourcedPart;
import capstone.code.domain.Part;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface InhousePartService {
    public List<InhousePart> findAll();
    public InhousePart findById(int theId);
    public void save (InhousePart thePart);
    public void deleteById(int theId);
}
