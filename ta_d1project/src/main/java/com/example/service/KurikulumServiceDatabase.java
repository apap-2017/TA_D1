package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KurikulumMapper;
import com.example.model.FakultasModel;
//import com.example.dao.KurikulumMapper;
import com.example.model.KurikulumModel;
import com.example.model.MataKuliahKurikulumModel;
import com.example.model.MataKuliahModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KurikulumServiceDatabase implements KurikulumService {
	@Autowired
	private KurikulumMapper kurikulumMapper;

	@Override
	public List<KurikulumModel> selectKurikulumProdi(int id_univ, int id_fakultas, int id_prodi) {
		log.info("select kurikulum with id prodi {}", id_prodi);
		return kurikulumMapper.selectKurikulumProdi(id_univ, id_fakultas, id_prodi);
	}

	@Override
	public String updateKurikulum(KurikulumModel kurikulum, int id_kurikulum) {
		log.info("update kurikulum with id {}", id_kurikulum);
		kurikulumMapper.updateKurikulum(kurikulum, id_kurikulum);

		return kurikulum.getNama_kurikulum();
	}

	@Override
	public void deleteKurikulum(int id) {
		log.info("delete kurikulum with id {}", id);
		kurikulumMapper.deleteKurikulum(id);
	}

	// lihat hasil cari kurikulum
	@Override	
	public List<KurikulumModel> selectKurikulumbyParam(int id_univ, int id_fakultas, int id_prodi) {
		log.info("select kurikulum with id_fakultas, id_prodi {}", id_fakultas, id_prodi);
		return kurikulumMapper.selectKurikulumbyParam(id_univ, id_fakultas, id_prodi);
	}

	// lihat detail kurikulum
	@Override
	public KurikulumModel selectKurikulum(int id) {
		log.info("select kurikulum with id {}", id);
		return kurikulumMapper.selectKurikulum(id);
	}

	@Override
	public FakultasModel selectFakultasbyId(int id_fakultas, int id_univ) {
		log.info("select fakultas with id_fakultas {}", id_fakultas);
		return kurikulumMapper.selectFakultasbyId(id_fakultas, id_univ);
	}

	@Override
	public KurikulumModel selectKurikulumR(int id_univ, int id_fakultas, int id_prodi, int id) {
		log.info("select kurikulum with id {}", id);
		return kurikulumMapper.selectKurikulumR(id_univ, id_fakultas, id_prodi, id);
	}

	@Override
	public List<MataKuliahModel> selectMataKuliah(int id_kurikulum) {
		return kurikulumMapper.selectMataKuliah(id_kurikulum);
	}
	
	@Override
	public int addKurikulum(KurikulumModel kurikulum, int id_univ, int id_fakultas, int id_prodi) {
		kurikulum.setId_univ(id_univ);
		kurikulum.setId_fakultas(id_fakultas);
		kurikulum.setId_prodi(id_prodi);
		
		kurikulumMapper.addKurikulum(kurikulum);
		
		int id = kurikulumMapper.getLastKurikulum().getId();
		
		return id;
	}
	
	@Override
	public List<MataKuliahModel> getMataKuliahByTerm(KurikulumModel kurikulum, int term) {
		List<MataKuliahModel> listMataKuliah = new ArrayList<>();
		
		if(kurikulum != null) {
			int size = kurikulum.getListMataKuliahKurikulum().size();
			for(int i = 0; i < size; i++) {
				if(kurikulum.getListMataKuliahKurikulum().get(i).getTerm() == term) {
					List<MataKuliahModel> matkuls = kurikulum.getListMataKuliah();
					int id_matkul = kurikulum.getListMataKuliahKurikulum().get(i).getId_matkul();
					
					for(int j = 0; j < matkuls.size(); j++) {
						if(matkuls.get(j).getId() == id_matkul) {
							listMataKuliah.add(matkuls.get(j));
							log.info("{}", matkuls.get(j).getNama_matkul());
						}
					}
				}
			}
			return listMataKuliah;
		} else {
			return null;
		}
		
		
	}
	
	@Override
	public List<MataKuliahKurikulumModel> getMatkulKurikulumByTerm(KurikulumModel kurikulum, int term) {
		List<MataKuliahKurikulumModel> listMatkulKurikulum = new ArrayList<>();
		
		if(kurikulum != null) {
			int size = kurikulum.getListMataKuliahKurikulum().size();
			
			for(int i = 0; i < size; i++) {
				if(kurikulum.getListMataKuliahKurikulum().get(i).getTerm() == term) {
					listMatkulKurikulum.add(kurikulum.getListMataKuliahKurikulum().get(i));
				}
			}
			
			return listMatkulKurikulum;
		} else {
			return null;
		}
		
	}


	@Override
	public KurikulumModel selectKurikulumAPI(int id) {
		return kurikulumMapper.selectKurikulumAPI(id);
	}

	@Override
	public List<KurikulumModel> selectAllKurikulum(int id_prodi) {
		return kurikulumMapper.selectAllKurikulum(id_prodi);
	}

	@Override
	public List<KurikulumModel> selectKurikulumbyKode(int id_univ, int id_fakultas, int id_prodi, String kode_kurikulum) {
		log.info("select kurikulum with kode_kurikulum {}", kode_kurikulum);
		return kurikulumMapper.selectKurikulumbyKode(id_univ, id_fakultas, id_prodi, kode_kurikulum);
	}
}
