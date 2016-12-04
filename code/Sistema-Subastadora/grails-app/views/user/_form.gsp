
<div class="row">
	
	<div class="col-md-6">
		<label>Nombre de Usuario (*)</label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="userName"
			placeholder="Ingrese un Nombre"
			value="${userInstance?.userName}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Nombre (*)</label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="name"
			placeholder="Ingrese un Nombre"
			value="${userInstance?.name}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Apellido (*)</label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="lastName"
			placeholder="Ingrese un Apellido" value="${userInstance?.lastName}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Correo (*)</label>
		<div class="form-group">
		<g:textField class="form-control" name="email" maxlength="50"
			placeholder="Ingrese su correo electrónico"
			value="${userInstance?.email}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Direccion</label>
		<div class="form-group">
		<g:textField class="form-control" name="address" maxlength="50"
			placeholder="Ingrese una Dirección"
			value="${userInstance?.address}" />
		</div>
	</div>
	
	
	<div class="col-md-6">
		<label>Rol <span class="required-indicator">*</span></label>
				<div class="form-group">
				<g:select id="updater" class="form-control" name="roleId" from="${roleInstanceList}" value="${userInstance?.role?.id}"
				optionKey="id" optionValue="name" required=""noSelection="${['':'Seleccione un rol..']}"/>
				
				</div>
	</div>
	
	
	<div class="col-md-6">
		<label>Contraseña</label>
		<div class="form-group">
		<g:passwordField class="form-control" required="" name="password" id="pass1" value="${}"
			placeholder="Ingrese la contraseña"  />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Repita la contraseña<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:passwordField class="form-control" required="" name="password2" oninput="verificar(this)" value="${}"
			placeholder="Vuelva a ingresar la contraseña" />
		</div>
	</div>
	
	
	
</div>


