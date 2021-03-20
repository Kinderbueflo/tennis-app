package fr.fgirard.tennisapp.service;

import java.util.List;

import fr.fgirard.tennisapp.service.bo.ProfitBO;

public interface ProfitService {

	public List<ProfitBO> getProfits(final String period);
}
