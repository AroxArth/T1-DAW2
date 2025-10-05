package com.aron.t1parte2.mcvc_clients.model;

import java.sql.Date;

public record User(Long id, String dni, String nombres, String apellidos, Date nacimiento, int port) {


}
