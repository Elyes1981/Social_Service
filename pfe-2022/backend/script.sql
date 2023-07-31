INSERT INTO public.gouvernorat(
	idgouv, name, name_ar)
	VALUES (1, 'bizerte', 'bizerte');

INSERT INTO public.coopted_by_type(
	id, label, label_ar, label_fr)
	VALUES (1, 'C1', 'C1', 'C1');

INSERT INTO public.status(
	id, label, label_ar, label_fr)
	VALUES (4, 'Marié', 'Marié', 'Marié');

INSERT INTO public.gender(
	id, label, label_ar, label_fr)
	VALUES (2, 'F', 'Femme', 'Femme');

INSERT INTO public.delegation(
	iddele, gps_latitude, gps_longtitude, name, name_ar)
	VALUES (1, 33, 44, 'menzel bourguiba', 'menzel bourguiba');
INSERT INTO public.gouvernorat_delegations(
	gouvernorat_idgouv, delegations_iddele)
	VALUES (1, 1);
INSERT INTO public.residence_type(
	id, label, label_ar, label_fr)
	VALUES (1, 't1', 't1', 't1');
