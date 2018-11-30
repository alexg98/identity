package wavy.global.identity.utilities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.keycloak.representations.idm.ClientRepresentation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import wavy.global.identity.domain.Client;

public class ModelMapperUtil extends ModelMapper {

	public ModelMapperUtil(){
		super();
		getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);		
	}	

	public <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }
}
