select count(id) as FISH_COUNT
from fish_info fi left join fish_name_info fni 
    on fi.fish_type = fni.fish_type 
where fni.fish_name in ('bass', 'snapper')
