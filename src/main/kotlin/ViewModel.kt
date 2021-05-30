import androidx.compose.runtime.*

class ViewModel {
    lateinit var appState: AppState
        private set
    var topText: String by mutableStateOf("")
        private set
    var btnText: String by mutableStateOf("")
        private set

    init {
        update(AppState.DisconnectDevice)
    }

    private fun update(state: AppState) {
        appState = state
        topText = state.topText
        btnText = state.btnText
    }

    fun toDisconnectDeviceState() = update(AppState.DisconnectDevice)

    fun toConnectDeviceState(extraDevices: List<Device>) = update(AppState.ConnectDevice(extraDevices))

    fun toDeviceNotFoundState() = update(AppState.DeviceNotFound)

    fun toChooseDeviceState(targetDevices: List<Device>) = update(AppState.ChooseDevice(targetDevices))

    fun toConfirmDeviceState(device: Device) = update(AppState.ConfirmDevice(device))

    fun toFinalState() = update(AppState.FinalState)

    fun toErrorState(message: String) = update(AppState.ErrorState(message))
}

