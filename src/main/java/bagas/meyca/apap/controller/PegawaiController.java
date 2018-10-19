package bagas.meyca.apap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bagas.meyca.apap.service.InstansiService;
import bagas.meyca.apap.service.JabatanService;
import bagas.meyca.apap.service.PegawaiService;
import bagas.meyca.apap.service.ProvinsiService;

@Controller
public class PegawaiController {
	
	@Autowired
	private PegawaiService pegawaiService;
	
	@Autowired
	private ProvinsiService provinsiService;
	
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private InstansiService instansiService;
	
	@RequestMapping("/")
	private String home(Model model) {
	
		return "home";
	}
	
//	View Operation
	@RequestMapping(value = "/pegawai/view", method=RequestMethod.GET)
	private String viewPegawai(@RequestParam(value="NIP") String NIP, Model model) {
		
		return "pegawai/pegawai";
	}
	
//	Add Operation
	@RequestMapping(value="/pegawai/tambah", method=RequestMethod.GET)
	private String tambah(Model model) {
		
		return "pegawai/addPegawai";
	}
	
//	Extra
	@RequestMapping(value="/pegawai/termuda-tertua", method=RequestMethod.GET)
	private String lihatPegawaiTer(@RequestParam(value="idInstansi") Long idInstansi, Model model) {
		
		return "pegawai/youngest-oldest";
	}
	
	@RequestMapping(value="/pegawai/cari", method=RequestMethod.GET)
	private String cariPegawai(@RequestParam(value="idProvinsi", required=false, defaultValue="0") Long id_provinsi,
			@RequestParam(value="idInstansi", required=false, defaultValue ="0") Long id_instansi,
			@RequestParam(value="idJabatan", required=false, defaultValue ="0") Long id_jabatan, Model model) {
			
		return "pegawai/searchPegawai";
	}
}