<%@ page import="com.uni.sd.subastadora.util.CategoryEnum"%>
<div class="row">
	
	<div class="col-md-6">
		<label>Nombre del producto(*)</label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="name"
			placeholder="Ingrese el Nombre"
			value="${productInstance?.name}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Descripcion</label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="description"
			placeholder="Ingrese un Nombre"
			value="${productInstance?.description}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Informacion de envio</label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="shippingInfor"
			placeholder="Ingrese un Apellido" value="${productInstance?.shippingInfor}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Precio base</label>
		<div class="form-group">
		<g:textField class="form-control" name="price" maxlength="50"
			placeholder="Ingrese su correo electrónico"
			value="${productInstance?.price}" />
		</div>
	</div>
	
	
	
	<div class="col-md-6">
		<label> <span class="required-indicator">Usuario</span></label>
				<div class="form-group">
				<g:select id="updater" class="form-control" name="userId" from="${userInstanceList}" value="${productInstance?.user?.id}"
				optionKey="id" optionValue="name" required=""noSelection="${['':'Seleccione un usuario ..']}"/>
				</div>
	</div>
	
	<div class="col-md-6">

				<div class="fieldcontain required">
					<label for="category"> <g:message code="Diagnostico" />
						<span class="required-indicator">*</span>
					</label>
					<g:select name="Categoria" class="form-control"
						from="${CategoryEnum.values()}"
						value="${productInstance?.category}" optionKey="key" required=""
						noSelection="${['SIN_INDICIOS':'Seleccionar categoria']}"></g:select>
				</div>
			</div>

	
	
	
</div>



