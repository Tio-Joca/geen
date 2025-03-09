SELECT * FROM tab WHERE (tab.DataInicio <= pFim OR pFim IS NULL) AND (tab.DataFim >= pInicio OR pInicio IS NULL);
