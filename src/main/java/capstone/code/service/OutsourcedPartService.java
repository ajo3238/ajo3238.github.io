package capstone.code.service;

import capstone.code.domain.OutsourcedPart;
import capstone.code.domain.Part;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface OutsourcedPartService {
        public List<OutsourcedPart> findAll();
        public OutsourcedPart findById(int theId);
        public void save (OutsourcedPart thePart);
        public void deleteById(int theId);
}
