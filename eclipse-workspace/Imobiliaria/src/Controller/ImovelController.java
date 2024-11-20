package Controller;

import Dao.ImovelDao;
import Imobiliaria.imovel;

import java.sql.SQLException;
import java.util.List;

public class ImovelController {
	    private ImovelDao imovelDao;
	    
	    public ImovelController() {
	        imovelDao = new ImovelDao();
	    }
	    
	    public void adicionarImovel(imovel imovel) {
	        try {
	            imovelDao.adicionarImovel(imovel);
	        } catch (SQLException e) {
	            e.printStackTrace();
	
}
}
	    
	    public List<imovel> listarImoveis() {
	        try {
	            return imovelDao.listarImoveis();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	            return null;
	        }
	    }
	}
	
