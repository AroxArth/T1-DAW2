package com.aron.springcloud.msvc_items.model;

import java.sql.Date;

public record User(Long id, String dni, String nombres, String apellidos, Date nacimiento, int port) {

}
