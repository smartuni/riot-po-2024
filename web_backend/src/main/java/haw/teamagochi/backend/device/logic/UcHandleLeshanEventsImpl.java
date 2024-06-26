package haw.teamagochi.backend.device.logic;

import haw.teamagochi.backend.device.logic.registrationmanager.RegistrationManager;
import haw.teamagochi.backend.leshanclient.datatypes.events.AwakeDto;
import haw.teamagochi.backend.leshanclient.datatypes.events.CoaplogDto;
import haw.teamagochi.backend.leshanclient.datatypes.events.RegistrationDto;
import haw.teamagochi.backend.leshanclient.datatypes.events.UpdatedDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

/** Default implementation of {@link UcHandleLeshanEvents}. */
@ApplicationScoped
public class UcHandleLeshanEventsImpl implements UcHandleLeshanEvents {

  private static final Logger LOGGER = Logger.getLogger(UcHandleLeshanEventsImpl.class);

  @Inject RegistrationManager registrationManager;

  @Override
  public void handleRegistration(RegistrationDto dto) {
    LOGGER.debug("Received registration event: " + dto.endpoint + " (" + dto.registrationId + ")");

    registrationManager.addClient(dto.endpoint);
  }

  @Override
  public void handleDeregistration(RegistrationDto dto) {
    LOGGER.debug(
        "Received deregistration event: " + dto.endpoint + " (" + dto.registrationId + ")");
  }

  @Override
  public void handleUpdate(UpdatedDto dto) {
    LOGGER.debug(
        "Received update event: "
            + dto.registration.endpoint
            + "("
            + dto.update.registrationId
            + ")");
  }

  @Override
  public void handleSleeping(AwakeDto dto) {
    LOGGER.debug("Received sleeping event: " + dto.ep);
  }

  @Override
  public void handleAwake(AwakeDto dto) {
    LOGGER.debug("Received awake event: " + dto.ep);
  }

  @Override
  public void handleCoapLog(CoaplogDto dto) {
    LOGGER.debug("Received coap logging event: " + dto.ep);
  }
}
